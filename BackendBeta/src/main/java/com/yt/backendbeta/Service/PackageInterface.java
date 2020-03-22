package com.yt.backendbeta.Service;

import com.yt.backendbeta.Entity.Package;

public interface PackageInterface {

	public void addPackage(Package pack);
	public Package getPackageId(String packageId);
	public Package getPackageName(String name);
}
