## <p align="center">[Discord API](DISCORD_API)  Servers</p><hr>

Request: ```https://discord.com/api/v9/guilds/$SERVER_ID```

<br>
Objects:<br>
id -> Server ID<br>
name -> Server Name<br>
description -> Server Description<br>
owner_id -> User ID of server owner<br>


Response:
```a
{
	 "id": "933826598631792690",
	 "name": "Server von TerrificTable55",
	 "description": null,
	 "owner_id": "916091258013892699",
	 "roles": [
		 {
			 "id": "933826598631792690",
			 "name": "@everyone",
			 "permissions": "1071698660929",
			 "position": 0,
			 "color": 0,
			 "hoist": false,
			 "managed": false,
			 "mentionable": false,
			 "icon": null,
			 "unicode_emoji": null
		 },
		 {
			 "id": "939271317163745311",
			 "name": "hjksdfjkhsdfhjks",
			 "permissions": "8",
			 "position": 2,
			 "color": 0,
			 "hoist": false,
			 "managed": true,
			 "mentionable": false,
			 "icon": null,
			 "unicode_emoji": null,
			 "tags": { "bot_id": "939271033419100201" }
		 },
		 {
			 "id": "939271927212699689",
			 "name": "Verified",
			 "permissions": "1071698660929",
			 "position": 1,
			 "color": 0,
			 "hoist": false,
			 "managed": false,
			 "mentionable": false,
			 "icon": null,
			 "unicode_emoji": null
		 }
	 ],

	 "default_message_notifications": 0,
	 "mfa_level": 0,
	 "explicit_content_filter": 0,
	 "max_presences": null,
	 "max_members": 500000,
	 "max_video_channel_users": 25,
	 "vanity_url_code": null,
	 "premium_tier": 0,
	 "premium_subscription_count": 0,
	 "system_channel_flags": 0,
	 "preferred_locale": "en-US",
	 "rules_channel_id": null,
	 "public_updates_channel_id": null,
	 "hub_type": null,
	 "premium_progress_bar_enabled": false,
	 "nsfw": false,
	 "nsfw_level": 0
 }```