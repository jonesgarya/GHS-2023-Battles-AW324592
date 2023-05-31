public class LocationTester extends ConsoleProgram
{
    public void run()
    {
        Location loc = new Location();
        loc.setShip(false);
        println(loc.checkHit());
        loc.setStatus(2);
        println(loc.getStatus());
    }
}
