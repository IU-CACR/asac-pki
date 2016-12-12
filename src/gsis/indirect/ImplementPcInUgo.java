package gsis.indirect;

import gsis.ImplementRbac0InUgo;
import converters.Rbac0Converter;
import base.ImplementationComposition;

public class ImplementPcInUgo extends ImplementationComposition {

	public ImplementPcInUgo() {
		supImpl = new ImplementPcInRbac0();
		subImpl = new ImplementRbac0InUgo();
		converter = new Rbac0Converter();
	}

	public static String schemeName() {
		return "ugo";
	}
}
