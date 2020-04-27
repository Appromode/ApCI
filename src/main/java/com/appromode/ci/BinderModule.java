package com.appromode.ci;

import com.appromode.ci.Initialise;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BinderModule extends AbstractModule {
	
    private final Initialise plugin;
	
	public BinderModule(Initialise plugin) {
		this.plugin = plugin;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(this);
	}
	
	@Override
	protected void configure() {
		this.bind(Initialise.class).toInstance(this.plugin);
	}
}
