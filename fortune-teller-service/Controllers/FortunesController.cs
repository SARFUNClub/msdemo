using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using fortune_teller_service.Models;
using fortune_teller_service.Repositories;


namespace fortune_teller_service.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class FortunesController : ControllerBase
    {
        private IFortuneRepository _fortunes;

        private ILogger<FortunesController> _logger;

        public FortunesController(IFortuneRepository fortunes, ILogger<FortunesController> logger)
        {
            _fortunes = fortunes;
            _logger = logger;
        }

        // GET: api/fortunes
        [HttpGet]
        public IEnumerable<Fortune> Get()
        {
            _logger?.LogInformation("GET api/fortunes");
            return _fortunes.GetAll();
        }

        // GET api/fortunes/random
        [HttpGet("random")]
        public Fortune Random()
        {
            _logger?.LogInformation("GET api/fortunes/random");
            return _fortunes.RandomFortune();
        }

        // GET api/values
        // [HttpGet]
        // public ActionResult<IEnumerable<string>> Get()
        // {
        //     return new string[] { "value1", "value2" };
        // }

        // // GET api/values/5
        // [HttpGet("{id}")]
        // public ActionResult<string> Get(int id)
        // {
        //     return "value";
        // }

        // // POST api/values
        // [HttpPost]
        // public void Post([FromBody] string value)
        // {
        // }

        // // PUT api/values/5
        // [HttpPut("{id}")]
        // public void Put(int id, [FromBody] string value)
        // {
        // }

        // // DELETE api/values/5
        // [HttpDelete("{id}")]
        // public void Delete(int id)
        // {
        // }
    }
}
