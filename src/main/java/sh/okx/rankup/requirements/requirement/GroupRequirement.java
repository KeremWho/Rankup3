package sh.okx.rankup.requirements.requirement;

import org.bukkit.entity.Player;
import sh.okx.rankup.RankupPlugin;
import sh.okx.rankup.requirements.Requirement;

public class GroupRequirement extends Requirement {
  public GroupRequirement(RankupPlugin plugin) {
    super(plugin, "group");
  }

  protected GroupRequirement(Requirement clone) {
    super(clone);
  }

  @Override
  public boolean check(Player player) {
    for (String group : plugin.getPermissions().getPlayerGroups(null, player)) {
      for (String value : getValuesString()) {
        if (group.equalsIgnoreCase(value)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public Requirement clone() {
    return new GroupRequirement(this);
  }
}
