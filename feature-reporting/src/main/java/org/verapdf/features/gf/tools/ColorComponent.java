/**
 *
 */
package org.verapdf.features.gf.tools;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  Maksim Bezrukov
 */

public enum ColorComponent {
	GRAY_COMPONENTS(EnumSet.of(Colors.GRAY)),
	RGB_COMPONENTS(EnumSet.of(Colors.RED, Colors.GREEN, Colors.BLUE)),
	CMKY_COMPONENTS(EnumSet.of(Colors.CYAN, Colors.MAGENTA, Colors.YELLOW, Colors.BLACK));

	private final EnumSet<Colors> colors;

	ColorComponent(final EnumSet<Colors> colors) {
		this.colors = colors;
	}

	public int getSize() {
		return this.colors.size();
	}

	public EnumSet<Colors> getColors() {
		return this.colors;
	}

	public Map<String, String> createAttributesMap(double[] componentValues) {
		Map<String, String> attMap = new HashMap<>();
		for (Colors color : this.getColors()) {
			attMap.put(color.getName(), String.valueOf(componentValues[color.getPosition()]));
		}
		return attMap;
	}

	public enum Colors {
		GRAY(0, "gray"),
		RED(0, "red"),
		GREEN(1, "green"),
		BLUE(2, "blue"),
		CYAN(0, "cyan"),
		MAGENTA(1, "magenta"),
		YELLOW(2, "yellow"),
		BLACK(3, "black");

		private final int position;
		private final String name;

		Colors(final int position, final String name) {
			this.position = position;
			this.name = name;
		}

		public int getPosition() {
			return this.position;
		}

		public String getName() {
			return this.name;
		}
	}
}
