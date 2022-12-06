import java.util.ArrayList;

public class PetstorePojo {
    public int id;
    public categorypojo category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<TagPojo> tags;
    public String status;

    public PetstorePojo(int id, categorypojo category, String name, ArrayList<String> photoUrls, ArrayList<TagPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetstorePojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public categorypojo getCategory() {
        return category;
    }

    public void setCategory(categorypojo category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<TagPojo> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagPojo> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
/*
 {
                                  "id": 0,
                                 "category": {
                                     "id": 0,
                            "name": "string"
                          },
                          "name": "duman",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "string"
                            }
                          ],
                          "status": "available"
                        }
 */
