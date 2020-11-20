# Kingdomino Game Development Notes

## Development Status
* ~~Create Kingdomino main class;~~
* ~~Add menu bar to the Kingdomino frame;~~
* ~~Implement menu action listener to switch to different screen;~~
* ~~Create DominoPanel to display domino list;~~
* ~~Create PlayerBoardPanel to display player's board;~~
* ~~Add Mouse Action listener to player's main pane;~~
* ~~draw terrain after player drop the domino successfully;~~
* ~~switch to current player's screen automatically;~~
* reduce the screen blink;

## Idea
* Create only one JFrame for this game;
* when data (properties and dominoList) changes, repaint panel;
* Add menu so that player can choose to see other's screen;
* Use TabbedPane for each player;


## Issues
* frame will repaint, need to call setVisible(false) > switch panel > setVisible(true), but this will make the screen blink.
* After player see other's screen, it is very hard to go back to current player's screen.
	- add "current" menu item into menu.
* TabbedPane cannot fill up the parent panel.

## Questions
* how to trigger panel repaint without call frame.setVisible(false) > swicth panel > setVisible(true)?

* Strange, switch to current pane, we don't need seVisible(false), and it is fast.
