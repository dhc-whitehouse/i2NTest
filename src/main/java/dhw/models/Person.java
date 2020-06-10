package dhw.models;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String person_id;
    private Date created_datetime;
    private String created_by_username;
    private Date updated_datetime;
    private String updated_by_username;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
    private boolean deleted;
    private Short gender;
    private Short ethnicity;
    private Short nationality;
    private Short preferred_language;
    private Short religion;
    private String other;
    private Short status_id;
    private String person_reference_number;
    private String mobile_phone;
    private String other_phone;
    private String email_address;
    private String staff_allocation;
    private String team_allocation;
    private String interpreter_required;
    private String person_custody_details_id;
    private String team_id;
    private String org_id;
    private String area_id;

//    public Person(String personId){
//        this.person_id = personId;
//    }
    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public Date getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(Date created_datetime) {
        this.created_datetime = created_datetime;
    }

    public String getCreated_by_username() {
        return created_by_username;
    }

    public void setCreated_by_username(String created_by_username) {
        this.created_by_username = created_by_username;
    }

    public Date getUpdated_datetime() {
        return updated_datetime;
    }

    public void setUpdated_datetime(Date updated_datetime) {
        this.updated_datetime = updated_datetime;
    }

    public String getUpdated_by_username() {
        return updated_by_username;
    }

    public void setUpdated_by_username(String updated_by_username) {
        this.updated_by_username = updated_by_username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Short ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Short getNationality() {
        return nationality;
    }

    public void setNationality(Short nationality) {
        this.nationality = nationality;
    }

    public Short getPreferred_language() {
        return preferred_language;
    }

    public void setPreferred_language(Short preferred_language) {
        this.preferred_language = preferred_language;
    }

    public Short getReligion() {
        return religion;
    }

    public void setReligion(Short religion) {
        this.religion = religion;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Short getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Short status_id) {
        this.status_id = status_id;
    }

    public String getPerson_reference_number() {
        return person_reference_number;
    }

    public void setPerson_reference_number(String person_reference_number) {
        this.person_reference_number = person_reference_number;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getOther_phone() {
        return other_phone;
    }

    public void setOther_phone(String other_phone) {
        this.other_phone = other_phone;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getStaff_allocation() {
        return staff_allocation;
    }

    public void setStaff_allocation(String staff_allocation) {
        this.staff_allocation = staff_allocation;
    }

    public String getTeam_allocation() {
        return team_allocation;
    }

    public void setTeam_allocation(String team_allocation) {
        this.team_allocation = team_allocation;
    }

    public String getInterpreter_required() {
        return interpreter_required;
    }

    public void setInterpreter_required(String interpreter_required) {
        this.interpreter_required = interpreter_required;
    }

    public String getPerson_custody_details_id() {
        return person_custody_details_id;
    }

    public void setPerson_custody_details_id(String person_custody_details_id) {
        this.person_custody_details_id = person_custody_details_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getFirst_name().equals(person.getFirst_name()) &&
                getMiddle_name().equals(person.getMiddle_name()) &&
                getLast_name().equals(person.getLast_name()) &&
                getDate_of_birth().equals(person.getDate_of_birth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getMiddle_name(), getLast_name(), getDate_of_birth());
    }
}
