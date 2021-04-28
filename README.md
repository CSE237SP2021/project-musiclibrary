# cse237-project Music Library

### Iteration 1
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
10. User can find all songs that they added to any playlist in the "all" playlist (default playlist)

Does everything Work?

Currently, the program has minimal functionality, and works given the format restrictions.
We used Scanner.nextInt() to select options from our menus, and this will not work if a non-number is given.

How to use the program:

1. Use an IDE you are familiar with, 
OR
2. Open the command line / terminal
3. Navigate to the directory this README is in
4. Enter "./run.sh" (without quotations) in the terminal and hit enter


### Iteration 2
Completed User Stories:
1. User can delete songs and playlists.
 - Only user-made playlists can be deleted, and default playlists cannot be deleted.
2. User can add or delete multiple songs at once via the Edit menu.
3. User can favorite a song.
4. User can choose to play the next song or go back to the main menu after it is done playing. 
5. User can have empty playlists
 - Currently, the program asks for a initial song for creating a new playlists, but that song can be deleted later.
 - Default playlists come with no songs included.
6. User can play a random song from a playlist


User stories for the next iteration:
1. User can play the 'favorite' songs playlist
2. User can choose a song to start from when playing a playlist
3. User can edit songs
4. User's bad input is tolerated, sanitized or re-prompted in a more rigorous way
5. When adding a new playlist, user can add multiple songs while configuring the playlist to add.
6. Any suggestions from feedback

Does everything Work?
Yes.

The program has some format restrictions: 
We used Scanner.nextInt() to select options from our menus, and this will not work if a non-number is given.
When selecting playlists, only good input should be given (choose from the displayed indices).
Playing a playlist / displaying a song while being played may feel a bit awkward compared to last iteration,
due to asking if user wants to continue after each song.

How to use the program:
0. Use an IDE you are familiar with, 
OR
1. Open the command line / terminal
2. Navigate to the directory this README is in
3. Enter "./run.sh" (without quotations) in the terminal and hit enter

###Iteration 3
Completed User Stories:
1. At the end of every song, users can now choose whether to go onto the next song or loop the last song played.
2. At the end of every full playlist listen, users can now choose to start again from the top of the current playlist.
3. Users can configure a new playlist to contain zero or multiple songs
4. Improvement on handling bad inputs, so it will no longer crash the program
5. Users can create a random playlist of any length they choose consisting of random songs from the “all songs” playlist.
6. Minor bug fixes

Does everything work?
The program has some format restrictions: We used Scanner.nextInt() to select options from our menus, and this will not work if a non-number is given. When selecting playlists, only good input should be given (choose from the displayed indices) but if bad input is given, it will prompt the user for good input. Playing a playlist / displaying a song while being played may feel a bit awkward compared to last iteration, due to asking if user wants to continue after each song. Overall, this iteration was mostly polishing what we already had and adding some more new features. The program as a whole acts as intended.

How to use the program:
1. Use an IDE you are familiar with, OR
2. Open the command line / terminal
3. Navigate to the directory this README is in
4. Enter "./run.sh" (without quotations) in the terminal and hit enter
