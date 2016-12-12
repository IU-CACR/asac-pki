package measures;

import costs.IntSumCost;
import base.Action;
import base.Measurable;
import base.Measure;
import base.Property;
import base.WorkloadScheme;

public class InstancesSLeave extends Measure {
	public InstancesSLeave() {
		curMeasurement = new IntSumCost();
	}

	@Override
	public String getMeasureName() {
		return "AC_SLeave_Instances";
	}

	@Override
	public String getPrintFriendlyName() {
		return "Number of SLeave operations";
	}

	@Override
	public void preExecMeasurement(Measurable w) {
	}

	@Override
	public void postExecMeasurement(Measurable w) {
		Property p = new Property(WorkloadScheme.class, WorkloadScheme.Q_LASTACTION, new String[0]);
		Action a = (Action) w.getCurMeasure(p);
		if(a != null) {
			if(!a.isQuery && a.name.equals("SLeave")) {
				curMeasurement.aggregate(1);
			}
		}
	}

	@Override
	public boolean isMeasurementvalid(Measurable w) {
		Property p = new Property(WorkloadScheme.class, WorkloadScheme.Q_LASTACTION, new String[0]);
		return w.isMeasurable(p);
	}

}