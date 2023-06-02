public class PlayerTester extends ConsoleProgram
{
    public void run()
    {
        Player human = new Player();
        Player computer = new Player();
        
        human.chooseShipLocation(new Ship(2), 0, 0, 0);
        computer.chooseShipLocation(new Ship(5), 0, 0, 0);
        
        human.printMyShips();
        human.printMyGuesses();
        human.printOpponentGuesses();
    }
}
