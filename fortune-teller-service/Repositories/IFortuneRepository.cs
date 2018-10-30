using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using fortune_teller_service.Models;

namespace fortune_teller_service.Repositories
{
    public interface IFortuneRepository
    {
        IEnumerable<Fortune> GetAll();

        Fortune RandomFortune();
    }
}