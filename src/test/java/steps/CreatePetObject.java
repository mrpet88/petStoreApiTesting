package steps;

import net.thucydides.core.annotations.Steps;
import org.json.JSONArray;
import org.json.JSONObject;
import steps.utils.petStatus;

public class CreatePetObject {
    @Steps
    Long id = System.currentTimeMillis();
    static JSONObject pet = new JSONObject();

    public void addPetDetails() {
        JSONObject petObject = new JSONObject();
        JSONObject category = new JSONObject();
        JSONArray photoUrls = new JSONArray();
        JSONArray tags = new JSONArray();

        petObject.put("id", id);
        category.put("id", id);
        category.put("name", "categoryName" + id);
        petObject.put("category", category);
        petObject.put("name", "name" + id);
        photoUrls.put("photUrls" + id);
        petObject.put("photoUrls", photoUrls);

        JSONObject tag = new JSONObject();
        tag.put("id", id);
        tag.put("name", "tagName" + id);
        tags.put(tag);
        petObject.put("tags", tags);

        petObject.put("status", petStatus.Available.getStatus());
        this.pet = petObject;
    }

    public void updatePetDetails() {
        pet.remove("name");
        pet.remove("status");
        pet.put("name", "updatedName" + id);
        pet.put("status", petStatus.Pending.getStatus());
    }
}
