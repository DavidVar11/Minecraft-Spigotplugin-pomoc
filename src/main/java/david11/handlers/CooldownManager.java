package david11.handlers;

//import java.util.HashMap;
//import java.util.Map;
//
//public class CooldownManager {
//
//    private Map<String, Long> cooldowns = new HashMap<>();
//    private int cooldownTime;
//
//    public CooldownManager(int cooldownTime) {
//        this.cooldownTime = cooldownTime;
//    }
//
//    public boolean isOnCooldown(String kitName) {
//        if(cooldowns.containsKey(kitName)) {
//            long timeRemaining = cooldowns.get(kitName) - System.currentTimeMillis();
//            if(timeRemaining > 0) {
//                return true;
//            } else {
//                cooldowns.remove(kitName);
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
//
//    public void putOnCooldown(String kitName) {
//        cooldowns.put(kitName, System.currentTimeMillis() + (cooldownTime * 1000));
//    }
//}
