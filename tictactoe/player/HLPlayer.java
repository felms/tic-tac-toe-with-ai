package tictactoe.player;

import tictactoe.Move;

import java.util.ArrayList;
import java.util.List;

public class HLPlayer extends Player{

    private char aiPlayer;
    private char hPlayer;

    public HLPlayer(char playingAs) {
        super(playingAs);
        aiPlayer = this.getPlayingAs();
        hPlayer = aiPlayer == 'O' ? 'X' : 'O';
    }

    @Override
    public Move getMove(String table) {
        Cell cell = minimax(table.toCharArray(), aiPlayer);

        int x = cell.pos / 3 + 1;
        int y = cell.pos % 3 + 1;

        return new Move(x, y);
    }

    // Faz um movimento usando o algoritmo minimax
    public Cell minimax(char[] mBoard, char player) {

        List<Integer> emptyCells = getEmptyCells(mBoard);

        if (winning(mBoard, aiPlayer)) {
            Cell r = new Cell();
            r.score = 1;
            return r;
        } else if (winning(mBoard, hPlayer)) {
            Cell r = new Cell();
            r.score = -1;
            return r;
        } else if (!hasEmptyCells(mBoard)){
            Cell r = new Cell();
            r.score =  0;
            return r;
        }

        List<Cell> moves = new ArrayList<>();

        for (int i = 0; i < emptyCells.size(); i++) {
            Cell move = new Cell();
            move.pos = emptyCells.get(i);
            char[] newBoard = copy(mBoard);
            newBoard[emptyCells.get(i)] = player;

            if (player == aiPlayer) {
                Cell result = minimax(newBoard, hPlayer);
                move.score = result.score;
            } else {
                Cell result = minimax(newBoard, aiPlayer);
                move.score = result.score;
            }

            moves.add(move);
        }

        int bestScore;
        int bestIndex = 0;
        if (player == aiPlayer) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestIndex = i;
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestIndex = i;
                }
            }
        }

        return moves.get(bestIndex);
    }

    // Copia a tabela
    private char[] copy(char[] board) {
        char[] b = new char[9];

        for (int i = 0; i < board.length; i++) {
            b[i] = board[i];
        }

        return b;
    }

    // Retorna uma lista com todas as células vazias
    private List<Integer> getEmptyCells(char[] board) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                result.add(i);
            }
        }
        return result;
    }

    // Testa se o jogador selecionado
    // venceu o jogo
    private boolean winning(char[] board, char player) {

        if((board[0] == player && board[1] == player && board[2] == player)
            || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
                || (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
                || (board[0] == player && board[4] == player && board[8] == player)
                || (board[2] == player && board[4] == player && board[6] == player)) {
            return true;
        }

        return false;
    }

    // Testa se tem celulas vazias
    private boolean hasEmptyCells(char[] board) {

        for (char c : board) {
            if (c != 'X' && c != 'O') {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getMessage() {
        return "Making move level \"hard\"";
    }
}

// Estrutura para armazenar a posição e o
// de uma posição no tabuleiro
class Cell {
    int pos;
    int score;
}
