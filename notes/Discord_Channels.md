## <p align="center">[Discord API](DISCORD_API) Channels</p><hr>

Request: ```https://discord.com/api/v9/guilds/$SERVER_ID/channels```

Channel Types:
0 -> Text channel
2 -> Voice channel
4 -> Category

<br>
Objects:<br>
id -> Channel ID<br>
type -> Channel Type<br>
name -> Channel Name<br>
topic -> Channel Description<br>
rate_limit_per_user -> Message timeout<br>
nsfw -> True if nsfw_channel else False<br>
parent_id -> Category ID<br>
guild_id -> Server ID<br><br>


Respsonse:
```a
"channels": [
 	{
		 "id": "933826598631792691",
		 "type": 4,
		 "name": "Textkan\\u00e4le",
		 "position": 0,
		 "parent_id": null,
		 "guild_id": "933826598631792690",
		 "permission_overwrites": []
	 },
	 {
		 "id": "933826598631792692",
		 "type": 4,
		 "name": "Sprachkan\\u00e4le",
		 "position": 0,
		 "parent_id": null,
		 "guild_id": "933826598631792690",
		 "permission_overwrites": []
	 },
	 {
		 "id": "933826598631792694",
		 "last_message_id": null,
		 "type": 2,
		 "name": "Allgemein",
		 "position": 0,
		 "parent_id": "933826598631792692",
		 "bitrate": 64000,
		 "user_limit": 0,
		 "rtc_region": null,
		 "guild_id": "933826598631792690",
		 "permission_overwrites": [],
		 "rate_limit_per_user": 0,
		 "nsfw": false
	 },
	 {
		 "id": "939283577001111583",
		 "last_message_id": "957661694769909823",
		 "type": 0,
		 "name": "dafsdf",
		 "position": 0,
		 "parent_id": "933826598631792691",
		 "topic": null,
		 "guild_id": "933826598631792690",
		 "permission_overwrites": [],
		 "rate_limit_per_user": 0,
		 "nsfw": true
 	}
 ]
 ```