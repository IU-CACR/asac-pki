package measures;

import costs.DoubleReplaceCost;
import base.Measurable;
import base.Measure;

public class SchemeIOLAddAvg extends Measure {
	Measure io = new SchemeIOLAdd();
	Measure instances = new InstancesLAdd();

	public SchemeIOLAddAvg() {
		curMeasurement = new DoubleReplaceCost();
	}

	@Override
	public String getMeasureName() {
		return "Scheme_IO_LAdd_Avg";
	}

	@Override
	public String getPrintFriendlyName() {
		return "Average scheme I/O per LAdd operation";
	}

	@Override
	public void preExecMeasurement(Measurable w) {
		io.preExecMeasurement(w);
		instances.preExecMeasurement(w);
	}

	@Override
	public void postExecMeasurement(Measurable w) {
		io.postExecMeasurement(w);
		instances.postExecMeasurement(w);

		int ioCur = (Integer)io.getCurCost();
		double instCur = (Integer)instances.getCurCost();

		curMeasurement.aggregate(ioCur / instCur);
	}

	@Override
	public boolean isMeasurementvalid(Measurable w) {
		return io.isMeasurementvalid(w) && instances.isMeasurementvalid(w);
	}

}
