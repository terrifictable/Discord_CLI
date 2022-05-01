#!/bin/env python3

# =========================================================================
# ==                            Description                              ==
# ==     Send messages from discord server X to the webserver            ==
# ==     for the Client to see                                           ==
# =========================================================================

from discord.ext import commands
import requests
import time

client = commands.Bot(command_prefix='>')
token = open("./token", "r").readline()


@client.event
async def on_ready():
    print(client.user.__str__() + " Ready")


@client.event
async def on_message(msg):
    date = time.strftime("%d/%m/%Y | %H:%M:%S")
    messgae: str = f"[{date}] {msg.author}: {msg.content}" + "\n"

    data = {
        "server": str(msg.channel.id),
        "content": messgae
    }

    print(data)
    requests.post("http://localhost:5000/add", json=data)


client.run(token)
