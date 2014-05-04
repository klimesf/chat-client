chat-client
===========
Chat clients connects to `chat-server` (127.0.0.1:4567 by default) and is able to create a new room, enter/leave rooms, retrieve list of rooms and send messages to entered rooms. User can enter multiple rooms at once.

Communication is not secured in any way.

Accepts parameter `selectip`. If selectip is given, client asks user for server ip address and port.

List of commands
===========
`HELP` Displays list of commands
`CREATE <room>` Creates a room with given name
`ENTER <room>` Enters room with given name
`LEAVE <room>` Leaves room with given name
`LIST` Returns list of rooms on the server
`SEND <room> <message>` Sends message to the given room
`BYE` Disconnects from the server
