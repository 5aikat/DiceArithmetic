# DiceArithmetic

Many games require players to roll dice. While Six sided dice are most common, other dice are also
used. For instance games use 4 sided, 8 sided, 10 sided, 12, and 20 sided dice, just to name a few.
The number and sides of dice to roll are indicated using the notation `nDs` where `n` is the number
of dice to roll, and `s` is the number of sides on each dice.
E.g. 4D6 means "Roll four six-sided dice". Similarly 1D20 requires the player to roll one 20-sided
dice.
The "value" of a roll is the sum of all dice rolled. For example the value of 2D6 is the sum of
individual values obtained by rolling two Six-sided dice. The maximum possible value in this case
is 12 (both dice rolled a 6), while the minimum possible value is 2 (both dice rolled a 1).
In some games, users are required to roll dice of different types and then add, subtract, or otherwise
manipulate the values.
For instance, 4D6 + 1D4 means "Add the value of a 4D6 roll to the value of a 1D4 roll". The
minimum and maximum values possible in this case are respectively 5, and 28.

Supporting the following Dice only: 4, 6, 8, 10, 12, and 20 Sided.
For e.g.
$> diceRoller 4D6 + 3D4 # Valid, show a result.
$> diceRoller 4D6 + 3D25 # 25 Sided dice are not supported, show an error
message.
$> diceRoller 0D6 - 1D4 # 0 dice doesn't make sense, show an error
message.
$> diceRoller 3D8 - 2D4 # Valid, show a result.
$> diceRoller 3D8 - 2D4 + 4D6 # Valid, show a result.
$> diceRoller 4D11 + 3D4 # 11 Sided dice are not supported, show an error
message.
$> diceRoller 4D6+3D4 # Valid, spaces before/after operators should be
ignored.
$> diceRoller 4 D 6 + 3D4 # Invalid, no spaces allowed in nDs notation.
$> diceRoller 4d6 + 3D4 # Valid, treat d and D the same. Show result.
