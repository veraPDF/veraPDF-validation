package org.verapdf.model.impl.pd;

import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosBBox;
import org.verapdf.model.pdlayer.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * the object representing PDF page.
 * @author Sergey Shemyakov
 */
public class GFPDPage extends GFPDObject implements PDPage {

    /** Type name for GFPDPage */
    public static final String PD_PAGE_TYPE = "PDPage";

    /** Link name for page annotations */
    private static final String ANNOTS = "annots";
    /** Link name for page additional actions */
    private static final String ACTION = "AA";
    /** Link name for page content stream */
    private static final String CONTENT_STREAM = "contentStream";
    /** Link name for page transparency group */
    private static final String GROUP = "Group";
    /** Link name for page media box */
    private static final String MEDIA_BOX = "MediaBox";
    /** Link name for page crop box */
    private static final String CROP_BOX = "CropBox";
    /** Link name for page bleed box */
    private static final String BLEED_BOX = "BleedBox";
    /** Link name for trim media box */
    private static final String TRIM_BOX = "TrimBox";
    /** Link name for page art box */
    private static final String ART_BOX = "ArtBox";
    /** Link name for page presentation steps */
    private static final String PRESENTATION_STEPS = "PresSteps";
    /** Link name for page group colorspace */
    private static final String GROUP_CS = "groupCS";

    private List<PDContentStream> contentStreams = null;

    /**
     * Default constructor
     * @param pdPage is greenfield parser PDPage.
     */
    public GFPDPage(org.verapdf.pd.PDPage pdPage) {
        super(pdPage, PD_PAGE_TYPE);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case GROUP:
                return this.getGroup();
            case ANNOTS:
                return this.getAnnotations();
            case ACTION:
                return this.getActions();
            case CONTENT_STREAM:
                return this.getContentStream();
            case MEDIA_BOX:
                return this.getMediaBox();
            case CROP_BOX:
                return this.getCropBox();
            case BLEED_BOX:
                return this.getBleedBox();
            case TRIM_BOX:
                return this.getTrimBox();
            case ART_BOX:
                return this.getArtBox();
            case GROUP_CS:
                return this.getGroupCS();
            default:
                return super.getLinkedObjects(link);
        }
    }

    //TODO: implement me:
    private List<PDGroup> getGroup() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<PDAnnot> getAnnotations() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<PDAction> getActions() {
        return Collections.emptyList();
    }


    private List<PDContentStream> getContentStream() {
        if (this.contentStreams == null) {
            parseContentStream();
        }
        return this.contentStreams;
    }

    private void parseContentStream() {
        this.contentStreams = new ArrayList<>(MAX_NUMBER_OF_ELEMENTS);
        org.verapdf.pd.PDPage page = (org.verapdf.pd.PDPage) this.simplePDObject;
        GFPDContentStream contentStream = new GFPDContentStream(page.getContent());
        contentStreams.add(contentStream);
    }

    //TODO: implement me:
    private List<CosBBox> getMediaBox() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<CosBBox> getCropBox() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<CosBBox> getBleedBox() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<CosBBox> getTrimBox() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<CosBBox> getArtBox() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    private List<PDColorSpace> getGroupCS() {
        return Collections.emptyList();
    }

    //TODO: implement me:
    /**
     * @return true if the page contains presentation steps
     * (/PresSteps in the page dictionary).
     */
    @Override
    public Boolean getcontainsPresSteps() {
        return null;
    }

    //TODO: implement me:
    /**
     * @return true if the page contains transparency.
     */
    @Override
    public Boolean getcontainsTransparency() {
        return null;
    }
}
