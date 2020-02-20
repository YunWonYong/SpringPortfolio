package com.spring.portfolio.common.util;

public class UtilityImpl implements UtilityCommand {

	public UtilityImpl() {
	}

	public boolean booleanTransform(Object obj) {
		boolean flag = false;
		switch (swithValue(obj)) {
		case 1:
			flag = true;
			break;
		case 2:
			flag = true;
			break;
		case 3:
			flag = true;
			break;
		case 4:
			flag = true;
			break;
		}
		return flag;
	}

	private int swithValue(Object obj) {
		int i = 0;
		if (obj instanceof Integer) {
			System.out.println("utilImpl = Integer:" + obj);
			i = (Integer) obj == 0 ? 0 : 1;
		} else if (obj instanceof Character) {
			System.out.println("utilImpl = Character:" + obj);
			i = (Character) obj == '0' ? 0 : 2;
		} else if (obj instanceof Boolean) {
			System.out.println("utilImpl = Boolean:" + obj);
			i = (Boolean) obj ? 3 : 0;
		} else if (obj instanceof Object) {
//			Class obj_class  = obj.getClass();
//			System.out.println("getCanonicalName = "+obj_class.getCanonicalName());
//			System.out.println("getModeifiers = "+obj_class.getModifiers());
//			System.out.println("getName = "+obj_class.getName());
//			System.out.println("getSimpleName = "+obj_class.getSimpleName());
//			System.out.println("getTypeName = "+obj_class.getTypeName());
			// System.out.println(classes[0].getSimpleName());
			i = obj != null?4:0;
		}
		return i;
	}

}
