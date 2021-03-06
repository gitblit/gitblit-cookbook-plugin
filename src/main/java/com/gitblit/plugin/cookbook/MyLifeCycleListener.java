/*
 * Copyright 2014 gitblit.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gitblit.plugin.cookbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.fortsoft.pf4j.Extension;

import com.gitblit.extensions.LifeCycleListener;
import com.gitblit.manager.IRuntimeManager;
import com.google.inject.Inject;

/**
 * Example lifecycle listener.
 *
 * @author James Moger
 *
 */
@Extension
public class MyLifeCycleListener extends LifeCycleListener {

	final Logger log = LoggerFactory.getLogger(getClass());

	final IRuntimeManager runtimeManager;

	@Inject
	public MyLifeCycleListener(IRuntimeManager runtimeManager) {
		this.runtimeManager = runtimeManager;
	}

    @Override
    public void onStartup() {
    	log.info("Gitblit is Ready!!");
    	log.info(" - booted @ {}", runtimeManager.getBootDate());
    }

    @Override
    public void onShutdown() {
    	log.info("Gitblit is Going Down!!");
    }
}