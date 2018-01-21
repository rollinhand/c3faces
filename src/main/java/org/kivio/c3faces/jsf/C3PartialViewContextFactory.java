/**
 Copyright 2015 Martin Linha

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 **/
package org.kivio.c3faces.jsf;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextFactory;

/**
 * Factory which is used to return extended version of PartialViewContext to allow writing callback scripts in eval part of response.
 *
 * @author Martin Linha
 */
public class C3PartialViewContextFactory extends PartialViewContextFactory {

    private final PartialViewContextFactory wrapped;

    public C3PartialViewContextFactory(PartialViewContextFactory wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * Return C3PartialViewContext to provide required funcionality.
     *
     * @param context Actual FacesContext instance
     * @return C3PartialViewContext instance
     */
    @Override
    public PartialViewContext getPartialViewContext(FacesContext context) {
        return new C3PartialViewContext(wrapped.getPartialViewContext(context));
    }

    /**
     * Return wrapped factory
     *
     * @return Wrapped PartialViewContextFactory
     */
    @Override
    public PartialViewContextFactory getWrapped() {
        return wrapped;
    }
}
