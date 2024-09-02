using ClinicService.Models;
using MySql.Data.MySqlClient;

namespace ClinicService.Services.Impl
{
    public class ConsultationRepository : IConsultationRepository
    {
        private const string connectionString = "Server=localhost; Database=Clinic; Uid=root; Pwd=402986;";

        public int Create(Consultation item)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "INSERT INTO Consultations(ClientId, PetId, ConsultationDate, Description) VALUES (@ClientId, @PetId, @ConsultationDate, @Description)";
                cmd.Parameters.AddWithValue("@PetId", item.PetId);
                cmd.Parameters.AddWithValue("@ClientId", item.ClientId);
                cmd.Parameters.AddWithValue("@Description", item.Description);
                cmd.Parameters.AddWithValue("@ConsultationDate", item.ConsultationDate.Ticks);
                cmd.Prepare();
                return cmd.ExecuteNonQuery();
            }
        }

        public int Delete(int id)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "DELETE FROM Consultations WHERE ConsultationId = @Id";
                cmd.Parameters.AddWithValue("@Id", id);
                cmd.Prepare();
                return cmd.ExecuteNonQuery();
            }
        }

        public List<Consultation> GetAll()
        {
            List<Consultation> consultations = new List<Consultation>();

            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "SELECT * FROM Consultations";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Consultation consultation = new Consultation
                        {
                            ConsultationId=reader.GetInt32("ConsultationId"),
                            ClientId = reader.GetInt32("ClientId"),
                            PetId = reader.GetInt32("PetId"),
                            Description = reader.GetString("Description"),
                            ConsultationDate = new DateTime(reader.GetInt64("ConsultationDate"))
                        };
                        consultations.Add(consultation);
                    }
                }
            }
            return consultations;
        }

        public Consultation GetById(int id)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "SELECT * FROM Consultations WHERE ConsultationId = @Id";
                cmd.Parameters.AddWithValue("@Id", id);
                cmd.Prepare();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        return new Consultation
                        {
                            ConsultationId=reader.GetInt32("ConsultationId"),
                            ClientId = reader.GetInt32("ClientId"),
                            PetId = reader.GetInt32("PetId"),
                            Description = reader.GetString("Name"),
                            ConsultationDate = new DateTime(reader.GetInt64("Birthday"))
                        };
                    }
                }
            }
            return null; // Клиент с таким id не найден
        }

        public int Update(Consultation item)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "UPDATE Consultations SET PetId = @PetId, ClientID = @ClientId, ConsultationDate = @ConsultationDate, Description = @Description WHERE ConsultationId = @Id";
                cmd.Parameters.AddWithValue("@Description", item.Description);
                cmd.Parameters.AddWithValue("@Id", item.ConsultationId);
                cmd.Parameters.AddWithValue("@ClientId", item.ClientId);
                cmd.Parameters.AddWithValue("@ConsultationDate", item.ConsultationDate.Ticks);
                cmd.Parameters.AddWithValue("@PetId", item.PetId);
                cmd.Prepare();
                return cmd.ExecuteNonQuery();
            }
        }
    }
}
