
namespace ClinicService.Services
{
    public interface IRepository<T, Tid>
    {
        int Create(T item);
        int Update(T item);
        int Delete(Tid id);
        T GetById(Tid id);
        List<T> GetAll();
    }
}
