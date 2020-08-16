package com.gbiblio.main;

class ClasseExterne {
	static int x = 10;
	static int y = 12;

	public static void main(String[] args) {

		ICalcul obj = new ICalcul() {
			float resultat;

			public float addition() {
				resultat = (float) (x + y);
				return (float) (x + y);
			}

			public float soustraction() {
				resultat = (float) (x - y);
				System.out.println(resultat);
				return resultat;
			}

			public float multiplication() {
				resultat = (float) x * (float) y;
				System.out.println(resultat);
				return resultat;
			}

			public float division() {
				if (y != 0) {
					resultat = (float) x / (float) y;
					System.out.println(resultat);
					return resultat;
				} else
					return 0;
			}
		};

		obj.addition();
		obj.soustraction();
		obj.multiplication();
		obj.division();
	}
}

interface ICalcul {
	float addition();

	float soustraction();

	float multiplication();

	float division();
}