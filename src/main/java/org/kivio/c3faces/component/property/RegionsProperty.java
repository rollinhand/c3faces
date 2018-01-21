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
package org.kivio.c3faces.component.property;

import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.property.Region;
import org.kivio.c3faces.script.property.Regions;
import org.kivio.c3faces.util.ComponentUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;

/**
 * This class allows to declare visual property of type org.kivio.c3faces.script.property.Regions in facelet.
 *
 * @author Martin Linha
 */
@FacesComponent("org.kivio.c3faces.component.property.RegionsProperty")
public class RegionsProperty extends C3Property {

    @Override
    public Property getAssociatedProperty() {
        Regions regions = new Regions();
        List<Region> regionList = null;
        for (UIComponent component : getChildren()) {
            if (component instanceof RegionProperty) {
                if (regionList == null) {
                    regionList = new ArrayList<>();
                }
                Region region = new Region((String) component.getAttributes().get(RegionProperty.ATTR_AXIS),
                        ComponentUtil.parseDouble(component.getAttributes().get(RegionProperty.ATTR_START)),
                        ComponentUtil.parseDouble(component.getAttributes().get(RegionProperty.ATTR_END)),
                        (String) component.getAttributes().get(RegionProperty.ATTR_CSS_CLASS));
                regionList.add(region);
            }
        }
        if (regionList != null) {
            regions.getRegions().addAll(regionList);
        }
        return regions;
    }
}
