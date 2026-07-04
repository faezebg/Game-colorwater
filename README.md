#  Color Water Sort Game

A challenging puzzle game implemented in Java where players organize colored water into bottles by pouring and rearranging colors.

##  Overview

Color Water Sort is an engaging puzzle game that implements a complex sorting algorithm using Java data structures. Players must strategically pour colored water between bottles to arrange them by color, using a limited number of moves.

##  Features

- **Interactive Gameplay**: Command-line interface for bottle selection and water pouring
- **Custom Colors**: Define your own color palette for each game
- **Flexible Bottle Size**: Adjust bottle capacity based on difficulty
- **Bottle Navigation**: Select bottles using keyboard commands (next, previous, select)
- **Undo Functionality**: Track and manage game moves with undo capability
- **Smart Validation**: Automatic detection of completed bottles and game state

##  Game Mechanics

### Core Components

- **Bottles (Stacks)**: Color containers implemented using linked lists
- **Node System**: Circular doubly-linked list managing bottle relationships
- **Smart Moves**: Pour water between bottles with compatibility checking

### How to Play

1. Enter colors separated by spaces (e.g., "red blue green")
2. Specify maximum bottle size (e.g., 4)
3. Use commands to interact:
   - `select <number>` - Select a bottle
   - `nextSelect` - Move to next bottle
   - `selectPrev` - Move to previous bottle
   - `deSelect` - Deselect current bottle
   - `pour <number>` - Pour to target bottle

##  Architecture

### Class Hierarchy

```
Node<T>
  ├── Generic linked node with data
  ├── Supports prev/next pointers
  └── Contains associated Stack

Stack
  ├── Manages color storage (linked list)
  ├── Tracks bottle selection state
  └── Implements push/pop operations

Number
  ├── Circular doubly-linked list of bottles
  ├── Manages bottle insertion/deletion
  └── Maintains game bottle structure

WaterSortGame
  ├── Main game logic controller
  ├── Handles player moves
  ├── Manages game state
  └── Validates move legality

Main
  └── Entry point & user interface
```

### Data Structures Used

- **Circular Linked Lists**: For efficient bottle management
- **Stacks**: For color storage in bottles
- **Nodes**: Generic containers with bidirectional pointers

##  Getting Started

### Prerequisites

- Java 8 or higher
- A terminal or IDE with Java support (IntelliJ IDEA, Eclipse, VS Code)

### Compilation

```bash
javac src/*.java -d bin
```

### Running the Game

```bash
java -cp bin Main
```

##  Project Structure

```
Game-colorwater/
├── src/
│   ├── Main.java           # Game entry point
│   ├── WaterSortGame.java  # Game logic controller
│   ├── Node.java           # Generic linked list node
│   ├── Stack.java          # Bottle/Color storage
│   └── Number.java         # Bottle management
├── colorwater.iml          # IntelliJ project file
└── README.md              # This file
```

##  Game Rules

1. **Color Matching**: Only pour water of matching colors
2. **Bottle Capacity**: Cannot exceed maximum bottle size
3. **Win Condition**: All bottles contain only one color
4. **Efficiency**: Complete puzzles in minimum moves

##  Technical Details

### Bottle Management
- Bottles stored in circular linked list for O(1) navigation
- Each bottle contains a stack of colored water
- Selection mechanism for interactive gameplay

### Color Operations
- Randomization of initial color distribution
- Stack-based operations for push/pop
- Linked list traversal for color validation

### Game State
- Persistent game state between moves
- Move history for undo tracking
- Automatic completion detection

##  Known Issues & Future Improvements

- [ ] Implement undo system completion
- [ ] Add difficulty levels (easy, medium, hard)
- [ ] Implement solution hint system
- [ ] Add graphical user interface (GUI)
- [ ] Optimize randomization algorithm
- [ ] Add performance metrics
- [ ] Implement score tracking

##  Complexity Analysis

| Operation | Complexity | Notes |
|-----------|-----------|-------|
| Select Bottle | O(n) | Linear search in bottle list |
| Pour Water | O(m) | m = height of bottle |
| Display Game | O(n*m) | All bottles all colors |
| Find Bottle | O(n) | Circular list traversal |

##  Contributing

Contributions are welcome! Please feel free to submit pull requests for:
- Bug fixes
- Performance optimizations
- Code refactoring
- New features
- Documentation improvements


