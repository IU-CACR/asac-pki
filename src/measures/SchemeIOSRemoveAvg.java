package measures;

import costs.DoubleReplaceCost;
import base.Measurable;
import base.Measure;

public class SchemeIOSRemoveAvg extends Measure {
	Measure io = new SchemeIOSRemove();
	Measure instances = new InstancesSRemove();

	public SchemeIOSRemoveAvg() {
		curMeasurement = new DoubleReplaceCost();
	}

	@Override
	public String getMeasureName() {
		return "Scheme_IO_SRemove_Avg";
	}

	@Override
	public String getPrintFriendlyName() {
		return "Average scheme I/O per SRemove operation";
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
