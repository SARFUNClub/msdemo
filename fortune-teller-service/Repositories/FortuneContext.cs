using Microsoft.EntityFrameworkCore;
using fortune_teller_service.Models;

namespace fortune_teller_service.Repositories
{
    public class FortuneContext : DbContext
    {
        public FortuneContext(DbContextOptions<FortuneContext> options) : base(options)
        {            
        }

        public DbSet<Fortune> Fortunes {get; set;}
    }
}