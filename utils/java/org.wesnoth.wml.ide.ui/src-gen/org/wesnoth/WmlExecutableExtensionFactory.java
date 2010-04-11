
/*
 * generated by Xtext
 */
 
package org.wesnoth;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * generated
 */
public class WmlExecutableExtensionFactory implements IExecutableExtensionFactory, IExecutableExtension {

	private Logger log = Logger.getLogger(WmlExecutableExtensionFactory.class);
	private String clazzName;
	private IConfigurationElement config;

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
		throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
			this.config = config;
		}
		else {
			throw new IllegalArgumentException("couldn't handle passed data : "+data);
		}
	}
	
	public Object create() throws CoreException {
		org.wesnoth.internal.WmlActivator instance = org.wesnoth.internal.WmlActivator.getInstance();
		if (instance == null)
			throw new IllegalStateException("The bundle has not yet been activated. Make sure the Manifest.MF contains 'Bundle-ActivationPolicy: lazy'.");
		Bundle bundle = instance.getBundle();
		try {
			final Class<?> clazz = bundle.loadClass(clazzName);
			final Injector injector = org.wesnoth.internal.WmlActivator.getInstance().getInjector("org.wesnoth.Wml");
			final Object result = injector.getInstance(clazz);
			if (result instanceof IExecutableExtension)
				((IExecutableExtension) result).setInitializationData(config, null, null);
			return result;
		}
		catch (Exception e) {
			log.error(e);
			throw new CoreException(new Status(Status.ERROR, bundle.getSymbolicName(), e.getMessage(),e));
		}
	}
}
