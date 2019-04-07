package org.queue.coda;

public class Queue<E> {

	private final int INITINAL_CAPACITY = 6;
	private Object[] codaArray;
	private int testaCoda, fondoCoda, cardCoda, lunghezzaArray;

	/**
	 * Costruise una coda.
	 */
	public Queue() {
		this.codaArray = new Object[INITINAL_CAPACITY];
		this.testaCoda = 0;
		this.fondoCoda = 0;
		this.cardCoda = 0;
		this.lunghezzaArray = codaArray.length;
	}

	/**
	 * Inserisce un elemento in fondo alla coda tempo O(1) se viene eseguita
	 * La funzione VerificaRaddoppio() tempo O(n)
	 * 
	 * @param e un elemento di un qualsiasi tipo
	 */
	public void Enqueue(E e) {
		VerificaRaddoppio();
		cardCoda = cardCoda + 1;
		codaArray[fondoCoda] = e;
		fondoCoda = (fondoCoda + 1) % lunghezzaArray;

	}

	/**
	 * Estrae e restituisce un elemento in testa alla coda tempo O(1) se viene eseguita
	 * La funzione VerificaDimezzamento() tempo O(n)
	 * 
	 * La SuppressWarnings è corretta perche Enqueue(E e) inserisce nella coda solo
	 * Elementi di tipo E  
	 * @return Un elemento di un qualsiasi tipo
	 */
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

	/**
	 * 
	 * La SuppressWarnings è corretta perche Enqueue(E e) inserisce nella coda solo
	 * Elementi di tipo E  
	 * 
	 * @return Restituisce l'elemento in testa alla coda
	 */
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
	 * Se il numero di elmenti contenuti nella coda è uguale alla dimensione dello
	 * cosa, raddoppia la cosa: if (cardCoda == lunghezzaArray) raddoppia
	 */
	private void VerificaRaddoppio() {

		if (cardCoda == lunghezzaArray) {

			Object[] a1 = copyArray(codaArray, testaCoda, lunghezzaArray);
			Object[] a2 = copyArray(codaArray, 0, testaCoda);
			codaArray = mergeArray(a1, a2);
			
			
			/*Raddoppio array, lunghezzaArray mantine il riferimento a codaArray.length*/
			int size = lunghezzaArray;
			size = size * 2;
			
			/*
			 *Memorizza la nuova dimensione dell'array nella variabile lunghezza array*/
			lunghezzaArray = size;
			
			
			testaCoda = 0;
			fondoCoda = cardCoda;
			System.out.println("Verifica Raddoppio = " + lunghezzaArray);
		}

	}

	/**
	 * Se il numero di elmenti contenuti nella cosa è uguale alla dimensione dello
	 * coda diviso 4, dimezza la cosa: if (ccardCoda == lunghezzaArray / 4) dimezza
	 */
	private void VerificaDimezzamento() {

		if (cardCoda == lunghezzaArray / 4) {
			
			Object[] a1 = copyArray(codaArray, testaCoda, lunghezzaArray);
			Object[] a2 = copyArray(codaArray, 0, testaCoda);
			codaArray = mergeArray(a1, a2);
			
			int size = lunghezzaArray;
			size = size / 2;

			
			lunghezzaArray = size;
			testaCoda = 0;
			fondoCoda = cardCoda;

			System.out.println("Verifica Dimezzamento = " + lunghezzaArray);

		}
		
	}
	/**Copia un array iniziando da from fino a to tempo O(n)
	 * 
	 * @param initialArray Array da copiare
	 * @param from Inizio della copia
	 * @param to Fine della copia
	 * @return Un array di Object[] con valori da From fino a To
	 */
	private Object[] copyArray(Object[] initialArray, int from, int to) {
		
		
		Object[] arr = new Object[initialArray.length];
		
		int j = 0 ;
		
		for (int i = from; i < to; i++) {
			arr[j] = initialArray[i];
			j++;
		}
		return arr;
	}
	
	/**
	 * Fonde due array in un unico array, raddoppiando la sua dimensione. Tempo O(n)
	 * 
	 * @param a1 Un array Object[]
	 * @param a2 Un array Object[]
	 * @return un unico array di Object[] che risulta essere l'unione dei due array. 
	 */
	private Object[] mergeArray(Object[] a1, Object[] a2) {
		
		int lenght = a1.length + a2.length;
		
		Object[] arr = new Object[lenght];
		
		int i =0,j =0;
		
		for (; i < a1.length;) {
			arr[i] = a1[i];
			i++;
		}
		for (; j < a2.length; ) {
			arr[i - 1] = a2[j]; // arr[i - 1 ] perchè all'ultima pozisione di arr c'e il valore null
			i++;
			j++;
		}
		return arr;
	}

}
