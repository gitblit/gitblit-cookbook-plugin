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

import java.util.Collection;

import org.eclipse.jgit.transport.ReceiveCommand;

import ro.fortsoft.pf4j.Extension;

import com.gitblit.extensions.ReceiveHook;
import com.gitblit.git.GitblitReceivePack;
import com.gitblit.models.RepositoryModel;
import com.gitblit.models.UserModel;

/**
 * Example receive hook.
 *
 * @author James Moger
 *
 */
@Extension
public class MyReceiveHook extends ReceiveHook {

    @Override
    public void onPreReceive(GitblitReceivePack receivePack, Collection<ReceiveCommand> commands) {
        RepositoryModel repository = receivePack.getRepositoryModel();
        UserModel user = receivePack.getUserModel();
        receivePack.sendInfo("Hi {0}, I see {1} ref commands onPreReceive for {2}",
                        user.getDisplayName(),
                        commands.size(),
                        repository.name);
    }

    @Override
    public void onPostReceive(GitblitReceivePack receivePack, Collection<ReceiveCommand> commands) {
        RepositoryModel repository = receivePack.getRepositoryModel();
        UserModel user = receivePack.getUserModel();
        receivePack.sendInfo("Hi {0}, I see {1} ref commands onPostReceive for {2}",
                        user.getDisplayName(),
                        commands.size(),
                        repository.name);
    }
}