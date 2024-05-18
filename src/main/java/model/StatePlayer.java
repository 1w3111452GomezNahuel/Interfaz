package model;
/**
 * Esta clase representa el estado que puede tener un jugador
 *
 * Los estados del jugador son ENABLED (habilitado para jugar),
 * DISABLE (deshabilitado por perder el juego) o SUSPENDED (suspendido por perder un turno)
 *
 * @see Player
 *
 */
public enum StatePlayer {
    ENABLED, DISABLE,SUSPENDED
}
