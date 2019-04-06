package org.queue.coda;

import java.util.Arrays;

public class Queue<E> {

	private final int INITINAL_CAPACITY = 6;
	private Object[] codaArray;
	private int testaCoda, fondoCoda, cardCoda, lunghezzaArray;

	public Queue() {
		this.codaArray = new Object[INITINAL_CAPACITY];
		this.testaCoda = 0;
		this.fondoCoda = 0;
		this.cardCoda = 0;
		this.lunghezzaArray = codaArray.length;
	}

	public void Enqueue(E e) {
		VerificaRaddoppio();
		cardCoda = cardCoda + 1;
		codaArray[fondoCoda] = e;
		fondoCoda = (fondoCoda + 1) % lunghezzaArray;

	}

	@SuppressWarnings("unchecked")
	public E Dequeue() {
		VerificaDimezzamento();
		if (!Empty()) {
			cardCoda = cardCoda - 1;
			E x = (E) codaArray[testaCoda];
			testaCoda = (testaCoda + 1) % lunghezzaArray;
			VerificaDimezzamento();
			return x;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public E First() {
		if (!Empty()) {
			return (E) codaArray[testaCoda];
		}
		return null;
	}

	public boolean Empty() {
		return (cardCoda == 0);
	}

	/**
	 * Se il numero di elmenti contenuti nello stack è uguale alla dimensione dello
	 * stack, raddoppia lo stack: if (cimaPila == pilaArray.length) raddoppia
	 */
	private void VerificaRaddoppio() {

		if (cardCoda == codaArray.length) {
			int size = lunghezzaArray;
			size = size * 2;

			codaArray = Arrays.copyOf(codaArray, size);

			lunghezzaArray = codaArray.length;
			testaCoda = 0;
			fondoCoda = cardCoda;
			System.out.println("Verifica Raddoppio = " + lunghezzaArray);
		}

	}

	/**
	 * Se il numero di elmenti contenuti nello stack è uguale alla dimensione dello
	 * stack diviso 4, dimezza lo stack: if (cimaPila == pilaArray.length/4) dimezza
	 */
	private void VerificaDimezzamento() {

		if (cardCoda == lunghezzaArray / 4) {
			int size = lunghezzaArray;
			size = size / 2;

			codaArray = Arrays.copyOf(codaArray, size);
			lunghezzaArray = codaArray.length;
			testaCoda = 0;
			fondoCoda = cardCoda;

			System.out.println("Verifica Dimezzamento = " + lunghezzaArray);

		}

	}

}
