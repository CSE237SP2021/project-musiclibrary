# cse237-project Music Library

Completed User Stories:

1. Built skeleton of program 
  - MusicLibrary.java with MusicLibrary class and main method 
  - Playlist class, Song class, PlaylistHelper class, MusicPlayer class
2. User can use a script to complie & run the program
3. User can see a welcome message, current playlists and the main menu upon starting the program
5. User can select options from the main menu:
  - Play an existing playlist
  - View an existing playlist to play or edit
  - Add a new playlist
  - Quit the program
6. User can revert back to the main menu after finishing with their selected option
7. If a user selects an option not on the menu, they can re-select a valid option
8. User can play a playlist with main menu option 1
  - User can select a playlist to play from the list of current playlists
  - User can see the song title, artist name, remaining time of a song being played 
9. User can do the following with main menu option 2
  - See options to play, edit, or go back to main menu
  - Selecting the options, the user can:
    - View all the songs in the selected playlist
    - Select to either play or edit the given playlist or go back to main menu
10. User edit a playlist by adding a song with known title, artist, and playtime (in seconds)
11. User can add a new playlist to the library with main menu option3
  - User can name the new playlist
  - User must choose their first song to be in the new playlist (empty playlists not allowed as of now)
12. User can end the program with main menu option 4 (See a goodbye message, and program terminates)

User stories for the next iteration:

0. Refactor / comment / edit code according to feedback for clarity
1. User can delete songs and playlists through the program
2. User can 'favorite' a song
3. User can play the 'favorite' songs playlist
4. User can choose to set the mode of the player to shuffle or loop a playlist n times
5. User can choose a song to start from when playing a playlist
6. User can edit songs
7. User can have empty playlists
8. User's bad input is tolerated, sanitized or re-prompted in a more rigorous way
9. any suggestions from feedback


Does everything Work?

Currently, the program has minimal functionality, and works given the format restrictions.
We used Scanner.nextInt() to select options from our menus, and this will not work if a non-number is given.

How to use the program:

0. Use an IDE you are familiar with, 
OR
1. Open the command line / terminal
2. Navigate to the directory this README is in
3. Enter "./run.sh" (without quotations) in the terminal and hit enter
