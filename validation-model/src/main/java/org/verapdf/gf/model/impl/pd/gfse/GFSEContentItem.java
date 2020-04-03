package org.verapdf.gf.model.impl.pd.gfse;

import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BDC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_BMC;
import org.verapdf.gf.model.impl.operator.markedcontent.GFOp_EMC;
import org.verapdf.gf.model.impl.operator.textshow.GFOpTextShow;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_TJ_Big;
import org.verapdf.gf.model.impl.operator.textshow.GFOp_Tj;
import org.verapdf.model.GenericModelObject;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.operator.Operator;
import org.verapdf.model.selayer.SEContentItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GFSEContentItem extends GenericModelObject implements SEContentItem {

    public static final String CONTENT_ITEM_TYPE = "SEContentItem";

    public static final String CONTENT_ITEM = "contentItem";

    List<Operator> operators;

    public GFSEContentItem() {
        super(CONTENT_ITEM_TYPE);
    }

    public GFSEContentItem(String objectType, List<Operator> operators) {
        super(objectType);
        this.operators = operators;
    }

    protected GFSEContentItem(String objectType) {
        super(objectType);
    }

    @Override
    public List<? extends Object> getLinkedObjects(String link) {
        switch (link) {
            case CONTENT_ITEM:
                return this.getContentItem();
            default:
                return super.getLinkedObjects(link);
        }
    }

    private List<SEContentItem> getContentItem() {
        if (operators == null) {
            return Collections.emptyList();
        }
        int markedContentIndex = -1;
        Stack<Integer> markedContentStack = new Stack<>();
        List<SEContentItem> list = new ArrayList<>();
        for (int i = 0; i < operators.size(); i++) {
            String type = operators.get(i).getObjectType();
            if (type.equals(GFOp_BDC.OP_BDC_TYPE) || type.equals(GFOp_BMC.OP_BMC_TYPE)) {
                markedContentStack.push(i);
            } else if (type.equals(GFOp_EMC.OP_EMC_TYPE)) {
                if (!markedContentStack.empty()) {
                    markedContentIndex = markedContentStack.pop();
                    if (markedContentStack.empty()) {
                        list.add(new GFSEMarkedContent(operators.subList(markedContentIndex, i + 1)));
                        markedContentIndex = i;
                    }
                }
            }
            if (type.equals(GFOp_Tj.OP_TJ_TYPE) || type.equals(GFOp_TJ_Big.OP_TJ_BIG_TYPE)) {
                list.add(new GFSETextItem());
            }
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public String getsuspectRole() {
        return null;
    }

}
