package org.verapdf.gf.model.impl.sa;

import org.verapdf.model.GenericModelObject;
import org.verapdf.model.salayer.SARepeatedCharacters;
import org.verapdf.wcag.algorithms.entities.RepeatedCharacters;

public class GFSARepeatedCharacters extends GenericModelObject implements SARepeatedCharacters {

	public static final String REPEATED_CHARACTERS_TYPE = "SARepeatedCharacters";

	private final RepeatedCharacters repeatedCharacters;

	public GFSARepeatedCharacters(RepeatedCharacters repeatedCharacters) {
		super(REPEATED_CHARACTERS_TYPE);
		this.repeatedCharacters = repeatedCharacters;
	}

	@Override
	public Boolean getisNonSpace() {
		return repeatedCharacters.isNonSpace();
	}

	@Override
	public Long getnumberOfRepeatedCharacters() {
		return (long) repeatedCharacters.getNumberOfElements();
	}

	@Override
	public String getContext() {
		return repeatedCharacters.getBoundingBox().getLocation();
	}
}
