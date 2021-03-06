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

import com.gitblit.extensions.RepositoryLifeCycleListener;
import com.gitblit.models.RepositoryModel;

/**
 * Sample repository lifecycle listener.
 *
 * @author James Moger
 *
 */
@Extension
public class MyRepoLifeCycleListener extends RepositoryLifeCycleListener {

    final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void onCreation(RepositoryModel repo) {
    	log.info("Gitblit created {}", repo);
    }

    @Override
    public void onFork(RepositoryModel origin, RepositoryModel fork) {
    	log.info("{} forked to {}", origin, fork);
    }

    @Override
    public void onRename(String oldName, RepositoryModel repo) {
    	log.info("{} renamed to {}", oldName, repo);
    }

    @Override
    public void onDeletion(RepositoryModel repo) {
    	log.info("Gitblit deleted {}", repo);
    }
}