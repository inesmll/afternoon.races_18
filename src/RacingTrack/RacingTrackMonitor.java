package RacingTrack;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RacingTrackMonitor implements IRacingTrack_Broker, IRacingTrack_Horse {

    private final Reentrantlock r1;
    private final Condition broker;
    private final Condition horse;

    public RacingTrackMonitor(int distance){ //dizer distancia aquando instanciamento
        this.r1 = new ReentrantLock();
        this.horse = r1.newCondition;
    }

    //wake horse
    public void startRace(){ //função do broker
        r1.lock();
        try{
            //waking up horses to start race
            horse.signal();
        }
        finally{
            r1.unlock();
        }
    }

    public proceedToStartLine(){
        r1.lock()
        try{
        }
            try{
                while(true){
                    //the spectator is waken up?
                    horse.await();
                    break;
                }
            }catch (Exception e){}
        }finally{
            r1.unlock();
    } //função do cavalo

    //wake horse
    public makeAMove(int id){ //entra o HorseThread e não o ID para conseguir aceder aos atributos
        r1.lock();

        try{
            moves = moves + maxUnits; //cavalo avança maxUnit passos, sendo esses passos guardados no "moves"
            horse.signal(); //acordar outro cavalo
            if (!hasFinishLineBeenCrossed())
                horse.await();
        }
        finally{
            r1.unlock();
        }
    }

    //função do cavalo
    //entra os moves totais do cavalo e a distância total do track
    public boolean hasFinishLineBeenCrossed(int moves, int distance){ //função utilizada por todos os cavalos
        r1.lock();
        try{
            try{
                while(distance > moves){
                    horse.await() p//broker não pode fazer nada por enquanto
                }
            } catch (Exeption ex) {}
        }
        //do something here
        finally{
            r1.unlock();
        }
    }
}