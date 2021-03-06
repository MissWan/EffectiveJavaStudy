package book.effective_java.items.item1.staticfactorymethodinsteadofconstructors;

import java.util.EnumSet;

public class JavaEnumSetStudy {
	private enum Color {
		RED,GREEN,BLUE
	}
	
	private enum Number {
		N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,
		N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,
		N21,N22,N23,N24,N25,N26,N27,N28,N29,N30,
		N31,N32,N33,N34,N35,N36,N37,N38,N39,N40,
		N41,N42,N43,N44,N45,N46,N47,N48,N49,N50,
		N51,N52,N53,N54,N55,N56,N57,N58,N59,N60,
		N61,N62,N63,N64,N65
	}

	public static void main(String[] argv) {
		final EnumSet<Color> colorEnumSet = EnumSet.range(Color.RED, Color.BLUE);
		final EnumSet<Number> numberEnumSet = EnumSet.range(Number.N1,Number.N2);
		printEnumSet("colorEnumSet", colorEnumSet);
		printEnumSet("numberEnumSet", numberEnumSet);
	}
	
	final static private void printEnumSet  (final String enumSetName, final EnumSet<?> enumSet){
		System.out.println(enumSetName + " is " +enumSet.getClass().getName() + " with size " + enumSet.size());
	}
}
