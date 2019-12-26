package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.model.selayer.SEArtifact;
import org.verapdf.pd.structure.PDStructElem;
import org.verapdf.tools.TaggedPDFConstants;

public class GFSEArtifact extends GFSEGeneral implements SEArtifact {

    public static final String ARTIFACT_STRUCTURE_ELEMENT_TYPE = "SEArtifact";

    public GFSEArtifact(PDStructElem structElemDictionary) {
        super(structElemDictionary, TaggedPDFConstants.ARTIFACT, ARTIFACT_STRUCTURE_ELEMENT_TYPE);
    }
}
