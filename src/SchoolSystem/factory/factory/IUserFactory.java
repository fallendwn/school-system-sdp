package src.SchoolSystem.factory.factory;

public interface IUserFactory {
    IUser create(int id, String name, int age, Object... extraInformation);
}
