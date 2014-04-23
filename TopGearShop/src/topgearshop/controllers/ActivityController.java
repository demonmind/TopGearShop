/*
 * Author: TopGear Group
 * Module to monitor system activity. This module will include monitoring of
 * all activities such as login, creation of objects, work order progress, etc
 *
 * Used by the main controller when any activity requires logging.
 *
 *
 */

package topgearshop.controllers;

import topgearshop.models.ActivityTypeModel;
import topgearshop.utils.DataAccessLayer;

public class ActivityController {
  private ActivityTypeModel activity;
  public ActivityController()
  {
    
  }

  private Boolean LogActivity()
  {
    return DataAccessLayer.LogActivity(activity);
  }
}
