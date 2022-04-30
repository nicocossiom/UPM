package recursion;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class Crypto {

	public static PositionList<Integer> encrypt(PositionList<Character> alphabet, PositionList<Character> text) {
		PositionList<Integer> encriptado = new NodePositionList<Integer>();
		encrypt(alphabet, text, alphabet.first(), text.first(), 0, encriptado);
		return encriptado;
	}

	private static void encrypt(PositionList<Character> alphabet, PositionList<Character> text,
			Position<Character> calp, Position<Character> ctext, int counter, PositionList<Integer> encriptado) {
		if (ctext == null) { // caso base=recursion termina cuando salgo de text
			return;
		} else {
			int comparacion = ctext.element().compareTo(calp.element());
			if (comparacion == 0) { // character encontrado en alphabet
				encriptado.addLast(counter); // añado
				if (text.next(ctext) != null) {
					encrypt(alphabet, text, calp, text.next(ctext), 0, encriptado); // recursion si no me salgo de text
				}
			} else if (comparacion < 0) { // char de text debe estar a la izquierda del calp
				encrypt(alphabet, text, alphabet.prev(calp), ctext, --counter, encriptado);
			} else { //// char de text debe estar a la derecha del calp
				encrypt(alphabet, text, alphabet.next(calp), ctext, ++counter, encriptado);

			}
		}
	}

	private static void decrypt(PositionList<Character> alphabet, PositionList<Integer> encodedText,
			Position<Character> calp, Position<Integer> cenc, int counter, PositionList<Character> resultdecrypt) {

		if (cenc == null) { // caso base=recursion termina cuando salgo de encoded
			return;
		} else {
			if (counter == 0) { // char siguiente encontrado en alpha
				resultdecrypt.addLast(calp.element()); // añado a decriptado
				if (encodedText.next(cenc) != null) { // recursion si no me salgo de encoded
					decrypt(alphabet, encodedText, calp, encodedText.next(cenc), encodedText.next(cenc).element(),
							resultdecrypt);
				}
			} else if (counter < 0) { // recursion a la izquierda en alphabet
				decrypt(alphabet, encodedText, alphabet.prev(calp), cenc, ++counter, resultdecrypt);
			} else { // (counter>0), recursion a la derecha en alphabet {
				decrypt(alphabet, encodedText, alphabet.next(calp), cenc, --counter, resultdecrypt);
			}
		}
	}

	public static PositionList<Character> decrypt(PositionList<Character> alphabet, PositionList<Integer> encodedText) {
		PositionList<Character> resultdecrypt = new NodePositionList<Character>();
		decrypt(alphabet, encodedText, alphabet.first(), encodedText.first(), encodedText.first().element(),
				resultdecrypt);
		return resultdecrypt;
	}

}
