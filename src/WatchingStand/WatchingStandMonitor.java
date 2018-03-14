package WatchingStand;

public class WatchingStandMonitor implements IWatchingStand_Spectator, IWatchingStand_Broker{

    private final Reentrantlock r1;
    private final Condition b;
    private final Condition s;

    public WatchingStandMonitor{
        this.r1 = new ReentrantLock();
        this.b = r1.newCondition;
        this.s = r1.newCondition;
    }

    public void haveIWon(int bet, int horse_won){
        r1.lock();
        try{
            try {
                if (bet != horse_won)
                    s.wait(); //if the spectator didn't win, it sleeps
            }catch (Exception e){}
        }
        finally{
            r1.unlock();
        }
    }

    public void relaxABit(int id){
        r1.lock();
        try{
            try{
                while(true) {
                    s.wait(); //spectator is asleep
                    break;
                }
            }catch (Exception e){}
        }
        finally{
            r1.unlock();
        }
    }

    public void goWatchTheRace(){

        r1.lock();
        try{
            b.await(); //adormece o broker
        }
        finally{
            r1.unlock();
        }

    }

    public void reportResults(){
        r1.lock();
        try{
            s.signalAll() //acordar os espectadores
        }
        finally{
            r1.unlock();
        }
    }

    public void areThereAnyWinners(int bet, int horse_won){ //ver se algum espectador ganhou. Funcao executada antes do "haveIWon"
        r1.lock();
        try{
            b.signal() //acordar o broker
        }
        finally{
            r1.unlock();
        }
    }
}