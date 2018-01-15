package chess;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import View.ChessView;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessView chessView = new ChessView(board);
		ChessGame chessGame = new ChessGame(board);

		while (true) {
			System.out.print("start or end ? : ");
			String input = sc.nextLine();
			if (input.equals("start")) {
				log.info(chessView.showBoard());
			} else if (input.startsWith("move")) {
				String[] position = input.split(" ");
				chessGame.move(position[1], position[2]);
				log.info(chessView.showBoard());
			} else if (input.equals("end")) {
				break;
			} else {
				log.info("다시 입력해주세요");
			}
		}

		sc.close();
	}
}
