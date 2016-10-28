package org.verapdf.pdfa;

public class VeraGreenfieldFoundryProvider implements VeraFoundryProvider {
	private static final VeraFoundryProvider instance = new VeraGreenfieldFoundryProvider();

	private VeraGreenfieldFoundryProvider() {
	}

	public static void initialise() {
		Foundries.registerDefaultProvider(instance);
	}

	@Override
	public VeraPDFFoundry getInstance() {
		return VeraFoundry.getInstance();
	}

}
