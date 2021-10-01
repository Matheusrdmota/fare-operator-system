package repository;

import model.Fare;
import model.Operator;

import java.util.*;
import java.util.stream.Collectors;

public class Repository<T> {
    List<T> fakeDatabase = new ArrayList<>();

    public void insert(T model){
        fakeDatabase.add(model);
    }

    public List<T> getAll(){
        return fakeDatabase;
    }

    public Optional<T> getById(UUID id){
        return fakeDatabase.stream()
                .filter(x -> {
                    if(x instanceof Fare){
                        return ((Fare) x).getId() == id;
                    }
                    else{
                        return ((Operator) x).getId() == id;
                    }
                })
                .findFirst();
    }

    public void update(UUID id, T model){
        Optional<T> modelToBeUpdated = this.getById(id);
        if(modelToBeUpdated.isPresent()){
            fakeDatabase.remove(modelToBeUpdated);
            fakeDatabase.add(model);
        }else{
            throw new NoSuchElementException();
        }
    }

    public void deleteById(UUID id){
        Optional<T> modelToBeDeleted = this.getById(id);
        if(modelToBeDeleted.isPresent()){
            fakeDatabase.remove(modelToBeDeleted);
        }
        else{
            throw new NoSuchElementException();
        }
    }
}
